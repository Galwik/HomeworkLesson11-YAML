package configuration;

import model.Browser;
import model.EnvironmentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class TestProperties {

    static Logger logger = LoggerFactory.getLogger(TestProperties.class);
    YamlReader yamlReader = new YamlReader();
    private Browser browser;
    private List<EnvironmentModel> environments;

    public TestProperties() {
        setBrowserProperties();
        setEnvironmentProperties();
    }

    private void setEnvironmentProperties() {
        environments = YamlReader.getConfig().getEnvironment().getEnvironments();
        boolean foundActiveEnvironment = false;
        for (EnvironmentModel environmentModel : environments) {
            if (environmentModel.isActive()) {
                foundActiveEnvironment = true;
                Map<String, Object> environmentProperties = environmentModel.getProperties();
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Loaded properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                break;
            }
        }
    }

    private void setBrowserProperties() {
        browser = YamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
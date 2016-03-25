package encryptomania

import griffon.core.artifact.ArtifactManager
import griffon.core.test.GriffonUnitRule
import griffon.core.test.TestFor
import org.junit.Rule
import org.junit.Test

import javax.inject.Inject

import static com.jayway.awaitility.Awaitility.await
import static java.util.concurrent.TimeUnit.SECONDS

@TestFor(EncryptomaniaController)
class EncryptomaniaControllerTest {
    static {
        System.setProperty('org.slf4j.simpleLogger.defaultLogLevel', 'trace')
    }

    @Inject
    private ArtifactManager artifactManager

    private EncryptomaniaController controller

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    @Test
    void executeClickAction() {
        // given:
        controller.model = artifactManager.newInstance(EncryptomaniaModel)

        // when:
        controller.invokeAction('click')
        await().atMost(2, SECONDS)

        // then:
        assert 1 == controller.model.clickCount
    }
}

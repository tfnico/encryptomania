package encryptomania

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonController)
class EncryptomaniaController {
    EncryptomaniaModel model

    void click() {
        model.clickCount++
    }
}
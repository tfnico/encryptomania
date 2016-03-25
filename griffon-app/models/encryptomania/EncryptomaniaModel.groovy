package encryptomania

import griffon.core.artifact.GriffonModel
import griffon.transform.Observable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class EncryptomaniaModel {
    @Observable int clickCount = 0
}
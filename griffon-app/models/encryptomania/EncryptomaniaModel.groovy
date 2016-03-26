package encryptomania

import griffon.core.artifact.GriffonModel
import griffon.transform.Observable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class EncryptomaniaModel {

    @Observable String password = 'secret'
    @Observable String salt = '5c0744940b5c369b'
    // queryable?
    //cipher?
    //ivAlg?
    //keylength?

    @Observable String encrypted
    @Observable String decrypted



}
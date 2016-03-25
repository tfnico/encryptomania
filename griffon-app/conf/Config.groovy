application {
    title = 'encryptomania'
    startupGroups = ['encryptomania']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "encryptomania"
    'encryptomania' {
        model      = 'encryptomania.EncryptomaniaModel'
        view       = 'encryptomania.EncryptomaniaView'
        controller = 'encryptomania.EncryptomaniaController'
    }
}
job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/Alephdjcs/nodejsapp.git', 'master') { node ->
            node / gitConfigName('Alephdjcs')
            node / gitConfigEmail('Danilocerdas.13@Gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
    publishers {
        slackNotifications {
            notifyAborted(true)
            notifyFailure(true)
            notifyNotBuilt(false)
            notifyUnstable(false)
            notifyBackToNormal(true)
            notifySuccess(true)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            customMessage('')
            sendAs('')
            commitInfoChoice('NONE')
            teamDomain('')
            authToken('')
        }
    }
}

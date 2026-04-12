def buildApp() {
echo 'building the app'
}

def testApp() {
                echo 'Testing...'
                echo "${params.VERSION}"
}

def deployApp() {
                echo 'Deploying...'
                echo "deploying version ${params.VERSION}"
}


return this

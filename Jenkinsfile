pipeline {
    agent any

    parameters{
        choice choices: ['chrome','firefox','opera'], description: "Choose a browser", name: "browser"
        string defaultValue: "src/test/resources/testng-smoke.xml", description: "surefire path", name: "surefire"
    }

    stages {
        stage('Build'){
            steps{
                echo 'Building...'
                // Get code from GitHub repository
                git "https://github.com/alex-evt/saucedemo.git"

                //Run Maven on a Windows agent
                bat "mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${surefire} clean test"
            }
        }

        stage('Reporting'){
            steps{
                script{
                    allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
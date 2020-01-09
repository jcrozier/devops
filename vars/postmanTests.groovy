/**
 * Use newman to run postman tests.
 *
 * Example: 
 *
 * 	postmanTest(jbossEnvironment: ${jbossEnvironmentGlobal} xmlFilename: "var/reports/newman/junit/newman.xml" htmlFilename: "var/reports/newman/html/index.html")

 *
 **/
def call(Map params) {

    bat 'newman run ${jbossEnvironment}postman_collection.json -e ${jbossEnvironment}.postman_environment.json -r junit,html --reporter-junit-export ${xmlFilename} --reporter-html-export ${htmlFilename}'
}

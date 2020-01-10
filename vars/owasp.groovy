/**
 * Use owasp dependency checker to find vulnerabilities .
 *
 * Example: 
 *
 * 		owasp(datadir: "/usr/share/nvd", autoUpdate: "false")
 *
 **/
def call(Map params) {

    def odcInstallation = params.odcInstallation ?: ""
	def pattern = params.pattern ?: ""

    dependencyCheck additionalArguments: """ 
        -o "./" 
        -s "./"
        -f "ALL" 
        --prettyPrint""", odcInstallation: "${odcInstallation}"

    dependencyCheckPublisher pattern: "${pattern}"

}

/**
 * Send email with build status.
 *
 * Example: 
 *
 * 	emailNotifcation (jobBuildStatus: "Failed", jobName: ${env.JOB_NAME}. jobBuildNumber: ${env.BUILD_NUMBER}, jobBuildUrl: ${env.BUILD_URL}, emailList: "devEmail" )

 *
 **/
def call(Map params) {

	def ajobBuildStatus = params.jobBuildStatus ?: ""
	def ajobName = params.jobName ?: ""
	def ajobBuildNumber = params.jobBuildNumber ?: ""
	def ajobBuildNumber = params.jobBuildNumber ?: ""
	def devEmail = params.devEmail ?: ""

	emailext (
		subject: "${ajobBuildStatus}: Build ${ajobBuildStatus} - Job '${ajobName} [${ajobBuildNumber}]'",
		body: """<p>${ajobBuildStatus}: Build ${ajobBuildStatus} - Job '${ajobName} [${ajobBuildNumber}]':</p>
	    	<p>Check console output at &QUOT;<a href='${ajobBuildNumber}'>${ajobName} [${ajobBuildNumber}]</a>&QUOT;</p>""",
	 	recipientProviders: [[$class: '${devEmail}']]
	)
}

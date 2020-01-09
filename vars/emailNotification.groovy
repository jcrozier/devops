/**
 * Send email with build status.
 *
 * Example: 
 *
 * 	emailNotifcation (jobBuildStatus: "Failed", jobName: ${env.JOB_NAME}. jobBuildNumber: ${env.BUILD_NUMBER}, jobBuildUrl: ${env.BUILD_URL}, emailList: "devEmail" )

 *
 **/
def call(Map params) {

	def jobBuildStatus = params.jobBuildStatus ?: ""
	def jobName = params.jobName ?: ""
	def jobBuildNumber = params.jobBuildNumber ?: ""
	def jobBuildUrl = params.jobBuildUrl ?: ""
	def emailList = params.emailList ?: ""

	emailext (
		subject: "${jobBuildStatus}: Build ${jobBuildStatus} - Job '${jobName} [${jobBuildNumber}]'",
		body: """<p>${jobBuildStatus}: Build ${jobBuildStatus} - Job '${jobName} [${jobBuildNumber}]':</p>
	    	<p>Check console output at &QUOT;<a href='${jobBuildNumber}'>${jobName} [${jobBuildUrl}]</a>&QUOT;</p>""",
	 	to: "${emailList}"
	)
}

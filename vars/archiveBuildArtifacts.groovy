/**
 * Archive build artifacts (does not error when no files match pattern)
 *
 * Example: 
 *
 *   archiveBuildArtifacts pattern: "*.jpeg"
 *
 **/
def call(Map params) {
  params = params ?: [:]

  archiveArtifacts artifacts: params.pattern, allowEmptyArchive: true
}

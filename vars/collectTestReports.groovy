/**
 * Add code coverage report to the build. Supports jacoco
 * and cobertura.
 *
 * Example: 
 *
 *   collectCodeCoverageResults reportPath: "**\/test\/jacocoTestReport.xml"
 *
 **/
def call(Map params) {
  params = params ?: [:]

  if (params.reportPath.endsWith("jacocoTestReport.xml")) {
    publishCoverage adapters: [
      jacocoAdapter(params.reportPath)
    ]
  } else {
    publishCoverage adapters: [
      istanbulCoberturaAdapter(params.reportPath)
    ]
  }

  return "Code Coverage Report - ${createJenkinsBuildUrl()}/coverage"
}

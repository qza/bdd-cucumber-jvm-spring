node ('jenkins-agent-java-1') {
  try{
    // slackSend channel: '#integration', message: "started ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", teamDomain: 'agileworks-tw', token: 'JhXFKEl6cBFoQ4v52BEJw9Mr'
    
    stage 'checkout project'
    checkout scm

    stage 'check env'

    sh "mvn -v"
    sh "java -version"

    try{
        stage 'test'
        sh "mvn test"
    }finally{
        stage 'report'
        step([$class: 'CukedoctorPublisher', featuresDir: '', format: 'HTML', hideFeaturesSection: false, hideScenarioKeyword: false, hideStepTime: false, hideSummary: false, hideTags: false, numbered: true, sectAnchors: true, title: 'Living Documentation', toc: 'RIGHT'])
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    }
    // slackSend channel: '#integration', color: 'good', message: "success ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", teamDomain: 'agileworks-tw', token: 'JhXFKEl6cBFoQ4v52BEJw9Mr'
  }catch(e){
    // slackSend channel: '#integration', color: 'danger', message: "fail ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", teamDomain: 'agileworks-tw', token: 'JhXFKEl6cBFoQ4v52BEJw9Mr'
    throw e;
  }
}

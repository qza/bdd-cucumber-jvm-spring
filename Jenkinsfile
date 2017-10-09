node {
  try{
    // slackSend channel: '#integration', message: "started ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", teamDomain: 'agileworks-tw', token: 'JhXFKEl6cBFoQ4v52BEJw9Mr'
    
    stage 'checkout project'
    //git url: 'https://github.com/agileworks-tw/spring-boot-sample.git'
    checkout scm

    stage 'check env'

    sh "mvn -v"
    sh "java -version"

    try{
        stage 'test'
        sh "mvn test"
    }finally{
        stage 'report'
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        step([$class: 'CukedoctorPublisher', featuresDir: '', format: 'HTML', hideFeaturesSection: false, hideScenarioKeyword: false, hideStepTime: false, hideSummary: false, hideTags: false, numbered: true, sectAnchors: true, title: 'Living Documentation', toc: 'RIGHT'])
    
    }
    // stage 'package'
    // sh "mvn package"

    // stage 'preview'
    // sh 'make deploy-default'

    // stage 'Artifact'
    // step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])

    // try{
    //  stage 'Approve, go production'
    //  def url = 'http://localhost:8000/'
    //  input message: "Does staging at $url look good? ", ok: "Deploy to production"
    // }finally{
    //  sh "ssh jenkins@localhost 'kill `cat deploy/release/run.pid`'"
    // }

    // stage 'deploy'
    // sh 'make deploy-default'

    // stage('SonarQube analysis') {
    // requires SonarQube Scanner 3
    // def scannerHome = tool 'SonarQube Scanner 3';
    // withSonarQubeEnv('Local Sonar') {
    //  sh "${scannerHome}/bin/sonar-scanner"
    // }
  // }

    // slackSend channel: '#integration', color: 'good', message: "success ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", teamDomain: 'agileworks-tw', token: 'JhXFKEl6cBFoQ4v52BEJw9Mr'
  }catch(e){
    // slackSend channel: '#integration', color: 'danger', message: "fail ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", teamDomain: 'agileworks-tw', token: 'JhXFKEl6cBFoQ4v52BEJw9Mr'
    throw e;
  }
}

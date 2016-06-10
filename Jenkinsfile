node() {
  stage 'Checkout Source Code'
  checkout([$class: 'GitSCM', branches: [[name: '**']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pomverte/boot-jpa-sample']]])
}

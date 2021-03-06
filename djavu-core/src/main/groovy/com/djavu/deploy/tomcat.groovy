package com.djavu.deploy

import org.apache.catalina.startup.Tomcat

import groovy.util.logging.Log

@Log
class Main {

	def tomcat = new Tomcat()

	static void main(String[] args) {

		log.info "Starting djavu-core..."

		def main = new Main('production')
		main.tomcat.server.await()
	}

	def stop() {
		tomcat.stop()
	}

	Main() {
		this('')
	}

	Main(String profiles) {

		def context = tomcat.addWebapp '/', new File('build/libs/djavu-core.war').absolutePath
		context.addParameter 'spring.profiles.default', profiles

		tomcat.port = 5000
		tomcat.start()
	}
}

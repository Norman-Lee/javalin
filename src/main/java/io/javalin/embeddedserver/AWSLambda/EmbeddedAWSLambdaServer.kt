package io.javalin.embeddedserver.AWSLambda

import com.amazonaws.services.lambda.runtime.Context
import io.javalin.core.JavalinServlet
import io.javalin.embeddedserver.EmbeddedServer
import org.slf4j.LoggerFactory


class EmbeddedAWSLambdaServer(private val javalinServlet: JavalinServlet) : EmbeddedServer{
    private val log = LoggerFactory.getLogger(EmbeddedServer::class.java)

    override fun start(port: Int): Int {
        log.info("Starting Javalin Server, ignoring the port")

//        javalinServlet.service(req, res)

        return 0
    }

    override fun stop() {
        log.info("Server stopped, nothing to do")
    }

    override fun activeThreadCount(): Int {
        log.info("Running on lambda, since it is one event per container, return value is always 1")
        return 1
    }

    override fun attribute(key: String): Any {
        log.info("No attributes as this is a lambda")
        return "No Attributes"
    }

}
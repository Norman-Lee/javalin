package io.javalin.embeddedserver.AWSLambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import org.slf4j.LoggerFactory
import java.io.BufferedReader
import java.security.Principal
import java.util.*
import javax.servlet.*
import javax.servlet.http.*
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.SecurityContext

class AwsProxyHttpServletRequest(AwsRequest : APIGatewayProxyRequestEvent, context: Context, AwsSecurityContext : SecurityContext) : HttpServletRequest {

    private val lambdaContext = context
    private val attributes = hashMapOf<String, Any>()
    private val request : APIGatewayProxyRequestEvent = AwsRequest
    private val urlEncodedParameters = hashMapOf<String, List<String>>()
    private val multiPartFormParameters = hashMapOf<String, Part>()
    private val securityContext : SecurityContext = AwsSecurityContext

    companion object {
        val HEADER_VALUE_SEPARATOR = ";"
        val HEADER_KEY_VALUE_SEPARATOR = "="
    }

    private var servletContext : ServletContext? = null

    // Might need AwsHttpSession object
    // Can't get dispatcher type to work

    private val log = LoggerFactory.getLogger(AwsProxyHttpServletRequest::class.java)


    //HttpServletRequest implementations
    override fun getAuthType(): String {
        return securityContext.authenticationScheme
    }
    override fun getCookies(): Array<Cookie> {
        val cookieHeader = getHeaderCaseInsensitive(HttpHeaders.COOKIE) ?: return arrayOf<Cookie>()

        return parseCookieHeaderValue(cookieHeader)
    }

    override fun getDateHeader(p0: String?): Long {

    }

    //HttpServletRequest Implementations

    override fun getRequestedSessionId(): String {
        throw UnsupportedOperationException()
    }

    override fun changeSessionId(): String? {
        return null
    }

    override fun isRequestedSessionIdValid(): Boolean {
        return false
    }

    override fun isRequestedSessionIdFromCookie(): Boolean {
        return false
    }

    override fun isRequestedSessionIdFromURL(): Boolean {
        return false
    }

    override fun isRequestedSessionIdFromUrl(): Boolean {
        return false
    }


    //ServletRequest Implementation

    override fun getAttribute(p0: String): Any? {
        return attributes[p0]
    }

    override fun getAttributeNames(): Enumeration<String> {
        return Collections.enumeration(attributes.keys)
    }

    override fun getServerName(): String {
        return "lambda.amazonaws.com"
    }

    override fun getServerPort(): Int {
        return 0
    }

    override fun setAttribute(p0: String, p1: Any) {
        attributes.put(p0, p1)
    }

    override fun removeAttribute(p0: String) {
        attributes.remove(p0)
    }

    override fun getLocalName(): String {
        return "lambda.amazonaws.com"
    }

    override fun getLocalAddr(): String? {
        return null
    }

    override fun getLocalPort(): Int {
        return 0
    }

    override fun getServletContext(): ServletContext? {
        return servletContext
    }

    override fun isAsyncStarted(): Boolean {
        return false
    }

    override fun isAsyncSupported(): Boolean {
        return false
    }

    override fun getAsyncContext(): AsyncContext? {
        return null
    }

    override fun getDispatcherType(): DispatcherType {
        return DispatcherType.REQUEST
    }






    override fun isUserInRole(p0: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startAsync(): AsyncContext {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startAsync(p0: ServletRequest?, p1: ServletResponse?): AsyncContext {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPathInfo(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProtocol(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getParameterMap(): MutableMap<String, Array<String>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRequestURL(): StringBuffer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun setCharacterEncoding(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParameterValues(p0: String?): Array<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRemoteAddr(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getContentLengthLong(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocales(): Enumeration<Locale> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRealPath(p0: String?): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(p0: String?, p1: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContextPath(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }









    override fun getRemoteHost(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getServletPath(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSession(p0: Boolean): HttpSession {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSession(): HttpSession {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




    override fun isSecure(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : HttpUpgradeHandler?> upgrade(p0: Class<T>?): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getPart(p0: String?): Part {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRemoteUser(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocale(): Locale {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMethod(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }






    override fun getQueryString(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getHeaders(p0: String?): Enumeration<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserPrincipal(): Principal {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParts(): MutableCollection<Part> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getReader(): BufferedReader {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getScheme(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInputStream(): ServletInputStream {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }






    override fun getCharacterEncoding(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParameterNames(): Enumeration<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun authenticate(p0: HttpServletResponse?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getPathTranslated(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContentLength(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHeader(p0: String?): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getIntHeader(p0: String?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getContentType(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getRequestURI(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRequestDispatcher(p0: String?): RequestDispatcher {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHeaderNames(): Enumeration<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getParameter(p0: String?): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRemotePort(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getHeaderCaseInsensitive(key : String) : String? {
        if(request.headers == null){
            return null
        }

        return request.headers.keys.firstOrNull { it.toLowerCase() == key.toLowerCase() }
    }

    private fun parseCookieHeaderValue(headerValue: String) : Array<Cookie> {

    }

    private fun parseHeaderValue(headerValue : String?) : List<Map.Entry<String, String>> {
        val values =
        if(headerValue == null){
            return values
        }

        headerValue.split(HEADER_VALUE_SEPARATOR).map{
            val kvSplit = it.split(HEADER_KEY_VALUE_SEPARATOR)
            if(kvSplit.size != 2){
                values.
            }
        }
    }

}
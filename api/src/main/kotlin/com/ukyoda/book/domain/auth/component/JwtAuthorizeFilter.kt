package com.ukyoda.book.domain.auth.component

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthorizeFilter(
    private val jwtComponent: JwtComponent,
    @Value("\${api.prefix}") private val apiPrefix: String,
) : OncePerRequestFilter() {
    private val matcher: AntPathRequestMatcher = AntPathRequestMatcher(apiPath("/login"))

    protected override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        if (!matcher.matches(request)) {
            val xAuthToken = request
                .getHeader("X-AUTH-TOKEN")
                ?.takeIf {
                    it.startsWith("Bearer ")
                }
            if (xAuthToken == null) {
                filterChain.doFilter(request, response)
                return
            }
            val decodedJwt = jwtComponent.decode(xAuthToken.substring(7))
            val username = decodedJwt.getClaim("username").toString()
            SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken(username, null, ArrayList())
        }
        filterChain.doFilter(request, response)
    }

    private fun apiPath(path: String): String = "$apiPrefix$path"

}
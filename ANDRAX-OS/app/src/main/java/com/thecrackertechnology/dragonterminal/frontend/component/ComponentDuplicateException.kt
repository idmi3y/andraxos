package com.thecrackertechnology.dragonterminal.frontend.component

/**
 * @author kiva
 */
class ComponentDuplicateException(serviceName: String) : RuntimeException("Service $serviceName duplicate")
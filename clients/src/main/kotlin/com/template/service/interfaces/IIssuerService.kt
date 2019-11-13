package com.template.service.interfaces

import com.template.dto.*

interface IIssuerService : IService {
    fun selfIssueService(request: SelfIssueFlowDTO) : SelfIssueDTO
}

interface IIssuerJPService : IService {
    fun selfIssueJPService(request: SelfIssueFlowJPDTO) : SelfIssueJPDTO
}

interface IMoveService {
    fun moveTokenService(request: IssuerToUserFlowDTO) : IssuerToUserDTO
}


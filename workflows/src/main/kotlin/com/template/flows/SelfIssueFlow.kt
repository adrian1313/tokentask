package com.template.flows

import com.r3.corda.lib.tokens.contracts.types.TokenType
import com.r3.corda.lib.tokens.contracts.utilities.heldBy
import com.r3.corda.lib.tokens.contracts.utilities.issuedBy
import com.r3.corda.lib.tokens.contracts.utilities.of
import com.r3.corda.lib.tokens.workflows.flows.issue.IssueTokensFlow
import com.template.functions.FlowFunctions
import net.corda.core.flows.StartableByRPC
import net.corda.core.transactions.SignedTransaction

    @StartableByRPC
    class SelfIssueFlow(private val amount: Double): FlowFunctions() {
        override fun call(): SignedTransaction {

            /*if (ourIdentity != stringToParty("Issuer"))
                throw FlowException("Platform cannot Self Issue")*/
//
            return when (ourIdentity) {
                stringToParty("BankPHP") -> {
                    val tokenPh = TokenType("PHPcoin", 2)
                    subFlow(IssueTokensFlow(amount of tokenPh issuedBy ourIdentity heldBy ourIdentity))
                }
                stringToParty("BankJP") -> {
                    val tokenJp = TokenType("YENcoin", 2)
                    subFlow(IssueTokensFlow(amount of tokenJp issuedBy ourIdentity heldBy ourIdentity))
                }
                else -> throw IllegalArgumentException("Invalid Bank")
            }



//            return when (ourIdentity) {
//                stringToParty("BankPHP") -> tokenPh("PHPcoin", 2)
//            stringToParty("BankJP") -> tokenJp("YENcoin", 2)
//            else -> throw IllegalArgumentException("Invalid Issuer")
//        }



        }

//        fun getToken(): TokenType {
//            return when (ourIdentity) {
//                stringToParty("BankPHP") -> TokenType("PHPcoin", 2)
//                stringToParty("BankJP") -> TokenType("YENcoin", 2)
//                else -> throw IllegalArgumentException("Invalid Issuer")
//            }
        }



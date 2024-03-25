package com.example.gbank

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.genesys.cloud.integration.messenger.MessengerAccount
import com.genesys.cloud.ui.structure.controller.*

class ChatActivity : AppCompatActivity() {

    private var deploymentID=""
    private var domain=""
    private var customerName=""
    private var customerID=""
    private var operationRequested=""
    private var transactionsIDs=""
    private var creditCardID=""
    private var tokenOAuth=""

    private fun loadChatConfiguration()
    {
        //TODO: Load Attributes from API or other Resources
        deploymentID="f11e8246-c7f6-4e9b-a2b6-911aec50f954"
        domain="mypurecloud.com"

    }
    private fun loadCustomAttributes()
    {
        customerName=getCustomerName()
        customerID=getCustomerID()
        operationRequested=getOperationRequested()
        transactionsIDs=getTransactionsIDs()
        creditCardID=encryptWithKMS(getCreditCardID())
        tokenOAuth=getTokenOAuth()

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        loadChatConfiguration()
        loadCustomAttributes()
        val messengerAccount = MessengerAccount(deploymentID,domain).apply { logging=false

            customAttributes= mapOf("CustomerName" to customerName,
                "CustomerID" to customerID,
                "OperationRequested" to operationRequested,
                "CreditCardID" to creditCardID,
                "TransactionsIDs" to transactionsIDs,
                "TokenOAuth" to tokenOAuth)
        }
        val chatController = ChatController.Builder(this).build(messengerAccount, object : ChatLoadedListener {
            override fun onComplete(result: ChatLoadResponse) {
                result.error?.let {
                    Log.d("ERROR","Chat loading failed")
                } ?: let {

                    supportFragmentManager.beginTransaction().replace(R.id.fragmentChat,result.fragment!!, "ChatActivity").commit()

                }
            }
        })





    }








    private fun getCustomerName(): String{
        return "Jordan2"
    }
    private fun getCustomerID(): String{
        return "41739991"
    }
    private fun getOperationRequested(): String{
        return "Claim on credit card transactions"
    }
    private fun getCreditCardID(): String{
        return "*********451"
    }
    private fun getTokenOAuth(): String{
        return "21312312312312312"
    }
    private fun getTransactionsIDs(): String{
        return "MOV00000002898|MOV00000001199|MOV00000006577"
    }
    private fun encryptWithKMS(value:String): String
    {
        return value
    }

}
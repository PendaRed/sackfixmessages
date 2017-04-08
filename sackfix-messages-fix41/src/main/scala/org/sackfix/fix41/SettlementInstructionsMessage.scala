package org.sackfix.fix41

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX41.xml
  */
case class SettlementInstructionsMessage(settlInstIDField:SettlInstIDField,
                                         settlInstTransTypeField:SettlInstTransTypeField,
                                         settlInstModeField:SettlInstModeField,
                                         settlInstSourceField:SettlInstSourceField,
                                         allocAccountField:AllocAccountField,
                                         settlLocationField:Option[SettlLocationField]=None,
                                         tradeDateField:Option[TradeDateField]=None,
                                         allocIDField:Option[AllocIDField]=None,
                                         lastMktField:Option[LastMktField]=None,
                                         sideField:Option[SideField]=None,
                                         securityTypeField:Option[SecurityTypeField]=None,
                                         effectiveTimeField:Option[EffectiveTimeField]=None,
                                         transactTimeField:TransactTimeField,
                                         clientIDField:Option[ClientIDField]=None,
                                         execBrokerField:Option[ExecBrokerField]=None,
                                         standInstDbTypeField:Option[StandInstDbTypeField]=None,
                                         standInstDbNameField:Option[StandInstDbNameField]=None,
                                         standInstDbIDField:Option[StandInstDbIDField]=None,
                                         settlDeliveryTypeField:Option[SettlDeliveryTypeField]=None,
                                         settlDepositoryCodeField:Option[SettlDepositoryCodeField]=None,
                                         settlBrkrCodeField:Option[SettlBrkrCodeField]=None,
                                         settlInstCodeField:Option[SettlInstCodeField]=None,
                                         securitySettlAgentNameField:Option[SecuritySettlAgentNameField]=None,
                                         securitySettlAgentCodeField:Option[SecuritySettlAgentCodeField]=None,
                                         securitySettlAgentAcctNumField:Option[SecuritySettlAgentAcctNumField]=None,
                                         securitySettlAgentAcctNameField:Option[SecuritySettlAgentAcctNameField]=None,
                                         securitySettlAgentContactNameField:Option[SecuritySettlAgentContactNameField]=None,
                                         securitySettlAgentContactPhoneField:Option[SecuritySettlAgentContactPhoneField]=None,
                                         cashSettlAgentNameField:Option[CashSettlAgentNameField]=None,
                                         cashSettlAgentCodeField:Option[CashSettlAgentCodeField]=None,
                                         cashSettlAgentAcctNumField:Option[CashSettlAgentAcctNumField]=None,
                                         cashSettlAgentAcctNameField:Option[CashSettlAgentAcctNameField]=None,
                                         cashSettlAgentContactNameField:Option[CashSettlAgentContactNameField]=None,
                                         cashSettlAgentContactPhoneField:Option[CashSettlAgentContactPhoneField]=None) extends SfFixMessageBody("T")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,settlInstIDField)
    fmt(b,settlInstTransTypeField)
    fmt(b,settlInstModeField)
    fmt(b,settlInstSourceField)
    fmt(b,allocAccountField)
    settlLocationField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    allocIDField.foreach(fmt(b,_))
    lastMktField.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    effectiveTimeField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    clientIDField.foreach(fmt(b,_))
    execBrokerField.foreach(fmt(b,_))
    standInstDbTypeField.foreach(fmt(b,_))
    standInstDbNameField.foreach(fmt(b,_))
    standInstDbIDField.foreach(fmt(b,_))
    settlDeliveryTypeField.foreach(fmt(b,_))
    settlDepositoryCodeField.foreach(fmt(b,_))
    settlBrkrCodeField.foreach(fmt(b,_))
    settlInstCodeField.foreach(fmt(b,_))
    securitySettlAgentNameField.foreach(fmt(b,_))
    securitySettlAgentCodeField.foreach(fmt(b,_))
    securitySettlAgentAcctNumField.foreach(fmt(b,_))
    securitySettlAgentAcctNameField.foreach(fmt(b,_))
    securitySettlAgentContactNameField.foreach(fmt(b,_))
    securitySettlAgentContactPhoneField.foreach(fmt(b,_))
    cashSettlAgentNameField.foreach(fmt(b,_))
    cashSettlAgentCodeField.foreach(fmt(b,_))
    cashSettlAgentAcctNumField.foreach(fmt(b,_))
    cashSettlAgentAcctNameField.foreach(fmt(b,_))
    cashSettlAgentContactNameField.foreach(fmt(b,_))
    cashSettlAgentContactPhoneField.foreach(fmt(b,_))
    b
  }

}
     
object SettlementInstructionsMessage extends SfFixMessageDecoder {
  val MsgType="T"
  val MsgName="SettlementInstructions"
             
  override val MandatoryFields = HashSet[Int](
    SettlInstIDField.TagId, SettlInstTransTypeField.TagId, SettlInstModeField.TagId, SettlInstSourceField.TagId, AllocAccountField.TagId, 
    TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    SettlLocationField.TagId, TradeDateField.TagId, AllocIDField.TagId, LastMktField.TagId, SideField.TagId, 
    SecurityTypeField.TagId, EffectiveTimeField.TagId, ClientIDField.TagId, ExecBrokerField.TagId, StandInstDbTypeField.TagId, 
    StandInstDbNameField.TagId, StandInstDbIDField.TagId, SettlDeliveryTypeField.TagId, SettlDepositoryCodeField.TagId, SettlBrkrCodeField.TagId, 
    SettlInstCodeField.TagId, SecuritySettlAgentNameField.TagId, SecuritySettlAgentCodeField.TagId, SecuritySettlAgentAcctNumField.TagId, SecuritySettlAgentAcctNameField.TagId, 
    SecuritySettlAgentContactNameField.TagId, SecuritySettlAgentContactPhoneField.TagId, CashSettlAgentNameField.TagId, CashSettlAgentCodeField.TagId, CashSettlAgentAcctNumField.TagId, 
    CashSettlAgentAcctNameField.TagId, CashSettlAgentContactNameField.TagId, CashSettlAgentContactPhoneField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SettlInstIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SettlementInstructionsMessage(SettlInstIDField.decode(myFields.get(SettlInstIDField.TagId)).get,
        SettlInstTransTypeField.decode(myFields.get(SettlInstTransTypeField.TagId)).get,
        SettlInstModeField.decode(myFields.get(SettlInstModeField.TagId)).get,
        SettlInstSourceField.decode(myFields.get(SettlInstSourceField.TagId)).get,
        AllocAccountField.decode(myFields.get(AllocAccountField.TagId)).get,
        myFields.get(SettlLocationField.TagId).flatMap(f=>SettlLocationField.decode(f)),
        myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
        myFields.get(AllocIDField.TagId).flatMap(f=>AllocIDField.decode(f)),
        myFields.get(LastMktField.TagId).flatMap(f=>LastMktField.decode(f)),
        myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(EffectiveTimeField.TagId).flatMap(f=>EffectiveTimeField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(ClientIDField.TagId).flatMap(f=>ClientIDField.decode(f)),
        myFields.get(ExecBrokerField.TagId).flatMap(f=>ExecBrokerField.decode(f)),
        myFields.get(StandInstDbTypeField.TagId).flatMap(f=>StandInstDbTypeField.decode(f)),
        myFields.get(StandInstDbNameField.TagId).flatMap(f=>StandInstDbNameField.decode(f)),
        myFields.get(StandInstDbIDField.TagId).flatMap(f=>StandInstDbIDField.decode(f)),
        myFields.get(SettlDeliveryTypeField.TagId).flatMap(f=>SettlDeliveryTypeField.decode(f)),
        myFields.get(SettlDepositoryCodeField.TagId).flatMap(f=>SettlDepositoryCodeField.decode(f)),
        myFields.get(SettlBrkrCodeField.TagId).flatMap(f=>SettlBrkrCodeField.decode(f)),
        myFields.get(SettlInstCodeField.TagId).flatMap(f=>SettlInstCodeField.decode(f)),
        myFields.get(SecuritySettlAgentNameField.TagId).flatMap(f=>SecuritySettlAgentNameField.decode(f)),
        myFields.get(SecuritySettlAgentCodeField.TagId).flatMap(f=>SecuritySettlAgentCodeField.decode(f)),
        myFields.get(SecuritySettlAgentAcctNumField.TagId).flatMap(f=>SecuritySettlAgentAcctNumField.decode(f)),
        myFields.get(SecuritySettlAgentAcctNameField.TagId).flatMap(f=>SecuritySettlAgentAcctNameField.decode(f)),
        myFields.get(SecuritySettlAgentContactNameField.TagId).flatMap(f=>SecuritySettlAgentContactNameField.decode(f)),
        myFields.get(SecuritySettlAgentContactPhoneField.TagId).flatMap(f=>SecuritySettlAgentContactPhoneField.decode(f)),
        myFields.get(CashSettlAgentNameField.TagId).flatMap(f=>CashSettlAgentNameField.decode(f)),
        myFields.get(CashSettlAgentCodeField.TagId).flatMap(f=>CashSettlAgentCodeField.decode(f)),
        myFields.get(CashSettlAgentAcctNumField.TagId).flatMap(f=>CashSettlAgentAcctNumField.decode(f)),
        myFields.get(CashSettlAgentAcctNameField.TagId).flatMap(f=>CashSettlAgentAcctNameField.decode(f)),
        myFields.get(CashSettlAgentContactNameField.TagId).flatMap(f=>CashSettlAgentContactNameField.decode(f)),
        myFields.get(CashSettlAgentContactPhoneField.TagId).flatMap(f=>CashSettlAgentContactPhoneField.decode(f))))
    } else None
  }

    
}
     
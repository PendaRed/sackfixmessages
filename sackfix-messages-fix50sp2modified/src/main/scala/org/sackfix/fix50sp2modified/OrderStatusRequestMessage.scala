package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class OrderStatusRequestMessage(orderIDField:Option[OrderIDField]=None,
                                     clOrdIDField:Option[ClOrdIDField]=None,
                                     secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                     clOrdLinkIDField:Option[ClOrdLinkIDField]=None,
                                     partiesComponent:Option[PartiesComponent]=None,
                                     ordStatusReqIDField:Option[OrdStatusReqIDField]=None,
                                     accountField:Option[AccountField]=None,
                                     acctIDSourceField:Option[AcctIDSourceField]=None,
                                     instrumentComponent:InstrumentComponent,
                                     financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                     undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                     sideField:SideField) extends SfFixMessageBody("H")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderIDField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    clOrdLinkIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    ordStatusReqIDField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    fmt(b,sideField)
    b
  }

}
     
object OrderStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="H"
  val MsgName="OrderStatusRequest"
             
  override val MandatoryFields = HashSet[Int](
    SideField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrderIDField.TagId, ClOrdIDField.TagId, SecondaryClOrdIDField.TagId, ClOrdLinkIDField.TagId, OrdStatusReqIDField.TagId, 
    AccountField.TagId, AcctIDSourceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderStatusRequestMessage(myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        myFields.get(ClOrdLinkIDField.TagId).flatMap(f=>ClOrdLinkIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(OrdStatusReqIDField.TagId).flatMap(f=>OrdStatusReqIDField.decode(f)),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        SideField.decode(myFields.get(SideField.TagId)).get))
    } else None
  }

    
}
     
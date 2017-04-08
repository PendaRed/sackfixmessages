package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class RegistrationInstructionsResponseMessage(registIDField:RegistIDField,
                                                   registTransTypeField:RegistTransTypeField,
                                                   registRefIDField:RegistRefIDField,
                                                   clOrdIDField:Option[ClOrdIDField]=None,
                                                   partiesComponent:Option[PartiesComponent]=None,
                                                   accountField:Option[AccountField]=None,
                                                   acctIDSourceField:Option[AcctIDSourceField]=None,
                                                   registStatusField:RegistStatusField,
                                                   registRejReasonCodeField:Option[RegistRejReasonCodeField]=None,
                                                   registRejReasonTextField:Option[RegistRejReasonTextField]=None) extends SfFixMessageBody("p")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,registIDField)
    fmt(b,registTransTypeField)
    fmt(b,registRefIDField)
    clOrdIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    fmt(b,registStatusField)
    registRejReasonCodeField.foreach(fmt(b,_))
    registRejReasonTextField.foreach(fmt(b,_))
    b
  }

}
     
object RegistrationInstructionsResponseMessage extends SfFixMessageDecoder {
  val MsgType="p"
  val MsgName="RegistrationInstructionsResponse"
             
  override val MandatoryFields = HashSet[Int](
    RegistIDField.TagId, RegistTransTypeField.TagId, RegistRefIDField.TagId, RegistStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ClOrdIDField.TagId, AccountField.TagId, AcctIDSourceField.TagId, RegistRejReasonCodeField.TagId, RegistRejReasonTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RegistIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(RegistrationInstructionsResponseMessage(RegistIDField.decode(myFields.get(RegistIDField.TagId)).get,
        RegistTransTypeField.decode(myFields.get(RegistTransTypeField.TagId)).get,
        RegistRefIDField.decode(myFields.get(RegistRefIDField.TagId)).get,
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        RegistStatusField.decode(myFields.get(RegistStatusField.TagId)).get,
        myFields.get(RegistRejReasonCodeField.TagId).flatMap(f=>RegistRejReasonCodeField.decode(f)),
        myFields.get(RegistRejReasonTextField.TagId).flatMap(f=>RegistRejReasonTextField.decode(f))))
    } else None
  }

    
}
     
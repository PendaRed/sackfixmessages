package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class ConfirmationRequestMessage(confirmReqIDField:ConfirmReqIDField,
                                      confirmTypeField:ConfirmTypeField,
                                      ordAllocGrpComponent:Option[OrdAllocGrpComponent]=None,
                                      allocIDField:Option[AllocIDField]=None,
                                      secondaryAllocIDField:Option[SecondaryAllocIDField]=None,
                                      individualAllocIDField:Option[IndividualAllocIDField]=None,
                                      transactTimeField:TransactTimeField,
                                      allocAccountField:Option[AllocAccountField]=None,
                                      allocAcctIDSourceField:Option[AllocAcctIDSourceField]=None,
                                      allocAccountTypeField:Option[AllocAccountTypeField]=None,
                                      textField:Option[TextField]=None,
                                      encodedTextLenField:Option[EncodedTextLenField]=None,
                                      encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("BH")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,confirmReqIDField)
    fmt(b,confirmTypeField)
    ordAllocGrpComponent.foreach(fmt(b,_))
    allocIDField.foreach(fmt(b,_))
    secondaryAllocIDField.foreach(fmt(b,_))
    individualAllocIDField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    allocAccountField.foreach(fmt(b,_))
    allocAcctIDSourceField.foreach(fmt(b,_))
    allocAccountTypeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object ConfirmationRequestMessage extends SfFixMessageDecoder {
  val MsgType="BH"
  val MsgName="ConfirmationRequest"
             
  override val MandatoryFields = HashSet[Int](
    ConfirmReqIDField.TagId, ConfirmTypeField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdAllocGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    AllocIDField.TagId, SecondaryAllocIDField.TagId, IndividualAllocIDField.TagId, AllocAccountField.TagId, AllocAcctIDSourceField.TagId, 
    AllocAccountTypeField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdAllocGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdAllocGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ConfirmReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(ConfirmationRequestMessage(ConfirmReqIDField.decode(myFields.get(ConfirmReqIDField.TagId)).get,
        ConfirmTypeField.decode(myFields.get(ConfirmTypeField.TagId)).get,
        OrdAllocGrpComponent.decode(flds, startPos),
        myFields.get(AllocIDField.TagId).flatMap(f=>AllocIDField.decode(f)),
        myFields.get(SecondaryAllocIDField.TagId).flatMap(f=>SecondaryAllocIDField.decode(f)),
        myFields.get(IndividualAllocIDField.TagId).flatMap(f=>IndividualAllocIDField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        myFields.get(AllocAccountField.TagId).flatMap(f=>AllocAccountField.decode(f)),
        myFields.get(AllocAcctIDSourceField.TagId).flatMap(f=>AllocAcctIDSourceField.decode(f)),
        myFields.get(AllocAccountTypeField.TagId).flatMap(f=>AllocAccountTypeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     
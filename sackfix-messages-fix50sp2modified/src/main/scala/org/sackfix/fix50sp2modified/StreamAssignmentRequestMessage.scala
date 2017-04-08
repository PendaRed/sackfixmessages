package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class StreamAssignmentRequestMessage(streamAsgnReqIDField:StreamAsgnReqIDField,
                                          streamAsgnReqTypeField:StreamAsgnReqTypeField,
                                          strmAsgnReqGrpComponent:StrmAsgnReqGrpComponent) extends SfFixMessageBody("CC")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,streamAsgnReqIDField)
    fmt(b,streamAsgnReqTypeField)
    fmt(b,strmAsgnReqGrpComponent)
    b
  }

}
     
object StreamAssignmentRequestMessage extends SfFixMessageDecoder {
  val MsgType="CC"
  val MsgName="StreamAssignmentRequest"
             
  override val MandatoryFields = HashSet[Int](
    StreamAsgnReqIDField.TagId, StreamAsgnReqTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    StrmAsgnReqGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    StrmAsgnReqGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    StrmAsgnReqGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==StreamAsgnReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(StreamAssignmentRequestMessage(StreamAsgnReqIDField.decode(myFields.get(StreamAsgnReqIDField.TagId)).get,
        StreamAsgnReqTypeField.decode(myFields.get(StreamAsgnReqTypeField.TagId)).get,
        StrmAsgnReqGrpComponent.decode(flds, startPos).get))
    } else None
  }

    
}
     
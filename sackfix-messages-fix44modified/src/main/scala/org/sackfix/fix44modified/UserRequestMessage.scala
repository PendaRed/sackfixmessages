package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class UserRequestMessage(userRequestIDField:UserRequestIDField,
                              userRequestTypeField:UserRequestTypeField,
                              usernameField:UsernameField,
                              passwordField:Option[PasswordField]=None,
                              newPasswordField:Option[NewPasswordField]=None,
                              rawDataLengthField:Option[RawDataLengthField]=None,
                              rawDataField:Option[RawDataField]=None) extends SfFixMessageBody("BE")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,userRequestIDField)
    fmt(b,userRequestTypeField)
    fmt(b,usernameField)
    passwordField.foreach(fmt(b,_))
    newPasswordField.foreach(fmt(b,_))
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    b
  }

}
     
object UserRequestMessage extends SfFixMessageDecoder {
  val MsgType="BE"
  val MsgName="UserRequest"
             
  override val MandatoryFields = HashSet[Int](
    UserRequestIDField.TagId, UserRequestTypeField.TagId, UsernameField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    PasswordField.TagId, NewPasswordField.TagId, RawDataLengthField.TagId, RawDataField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==UserRequestIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(UserRequestMessage(UserRequestIDField.decode(myFields.get(UserRequestIDField.TagId)).get,
        UserRequestTypeField.decode(myFields.get(UserRequestTypeField.TagId)).get,
        UsernameField.decode(myFields.get(UsernameField.TagId)).get,
        myFields.get(PasswordField.TagId).flatMap(f=>PasswordField.decode(f)),
        myFields.get(NewPasswordField.TagId).flatMap(f=>NewPasswordField.decode(f)),
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f))))
    } else None
  }

    
}
     
package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class CompIDsGroup(refCompIDField:RefCompIDField,
                        refSubIDField:Option[RefSubIDField]=None,
                        locationIDField:Option[LocationIDField]=None,
                        deskIDField:Option[DeskIDField]=None,
                        statusValueField:StatusValueField,
                        statusTextField:Option[StatusTextField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,refCompIDField)
    refSubIDField.foreach(fmt(b,_))
    locationIDField.foreach(fmt(b,_))
    deskIDField.foreach(fmt(b,_))
    fmt(b,statusValueField)
    statusTextField.foreach(fmt(b,_))
    b
  }

}
     
object CompIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int](
    RefCompIDField.TagId, StatusValueField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    RefSubIDField.TagId, LocationIDField.TagId, DeskIDField.TagId, StatusTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RefCompIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[CompIDsGroup]=ArrayBuffer.empty[CompIDsGroup]):Option[List[CompIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[CompIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[CompIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(CompIDsGroup(RefCompIDField.decode(myFields.get(RefCompIDField.TagId)).get,
          myFields.get(RefSubIDField.TagId).flatMap(f=>RefSubIDField.decode(f)),
          myFields.get(LocationIDField.TagId).flatMap(f=>LocationIDField.decode(f)),
          myFields.get(DeskIDField.TagId).flatMap(f=>DeskIDField.decode(f)),
          StatusValueField.decode(myFields.get(StatusValueField.TagId)).get,
          myFields.get(StatusTextField.TagId).flatMap(f=>StatusTextField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     
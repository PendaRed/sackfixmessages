package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class Nested4PartyIDsGroup(nested4PartyIDField:Option[Nested4PartyIDField]=None,
                                nested4PartyIDSourceField:Option[Nested4PartyIDSourceField]=None,
                                nested4PartyRoleField:Option[Nested4PartyRoleField]=None,
                                nstdPtys4SubGrpComponent:Option[NstdPtys4SubGrpComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    nested4PartyIDField.foreach(fmt(b,_))
    nested4PartyIDSourceField.foreach(fmt(b,_))
    nested4PartyRoleField.foreach(fmt(b,_))
    nstdPtys4SubGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object Nested4PartyIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NstdPtys4SubGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    Nested4PartyIDField.TagId, Nested4PartyIDSourceField.TagId, Nested4PartyRoleField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NstdPtys4SubGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NstdPtys4SubGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==Nested4PartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[Nested4PartyIDsGroup]=ArrayBuffer.empty[Nested4PartyIDsGroup]):Option[List[Nested4PartyIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[Nested4PartyIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[Nested4PartyIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(Nested4PartyIDsGroup(myFields.get(Nested4PartyIDField.TagId).flatMap(f=>Nested4PartyIDField.decode(f)),
          myFields.get(Nested4PartyIDSourceField.TagId).flatMap(f=>Nested4PartyIDSourceField.decode(f)),
          myFields.get(Nested4PartyRoleField.TagId).flatMap(f=>Nested4PartyRoleField.decode(f)),
          NstdPtys4SubGrpComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     
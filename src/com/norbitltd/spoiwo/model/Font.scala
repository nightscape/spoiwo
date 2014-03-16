package com.norbitltd.spoiwo.model

import com.norbitltd.spoiwo.model.enums.{FontScheme, Underline, FontFamily, Charset}

object Font extends Factory {

  private lazy val defaultHeight = -1.toShort
  private lazy val defaultHeightInPoints = -1.toShort
  private lazy val defaultBold = false
  private lazy val defaultItalic = defaultPOIFont.getItalic
  private lazy val defaultCharSet = Charset.Undefined
  private lazy val defaultColor = Color.Undefined
  private lazy val defaultFamily = FontFamily.Undefined
  private lazy val defaultScheme = FontScheme.Undefined
  private lazy val defaultFontName = defaultPOIFont.getFontName
  private lazy val defaultStrikeout = defaultPOIFont.getStrikeout
  private lazy val defaultTypeOffset = defaultPOIFont.getTypeOffset
  private lazy val defaultUnderline = Underline.Undefined

  val Default = Font()

  def apply(height: Short = defaultHeight,
            heightInPoints: Short = defaultHeightInPoints,
            bold: Boolean = defaultBold,
            italic: Boolean = defaultItalic,
            charSet: Charset = defaultCharSet,
            color: Color = defaultColor,
            family: FontFamily = defaultFamily,
            scheme: FontScheme = defaultScheme,
            fontName: String = defaultFontName,
            strikeout: Boolean = defaultStrikeout,
            typeOffset: Short = defaultTypeOffset,
            underline: Underline = defaultUnderline): Font = Font(
    height = wrap(height, defaultHeight),
    heightInPoints = wrap(heightInPoints, defaultHeightInPoints),
    bold = wrap(bold, defaultBold),
    italic = wrap(italic, defaultItalic),
    charSet = wrap(charSet, defaultCharSet),
    color = wrap(color, defaultColor),
    family = wrap(family, defaultFamily),
    scheme = wrap(scheme, defaultScheme),
    fontName = wrap(fontName, defaultFontName),
    strikeout = wrap(strikeout, defaultStrikeout),
    typeOffset = wrap(typeOffset, defaultTypeOffset),
    underline = wrap(underline, defaultUnderline)
  )
}

case class Font private[model](
                                height: Option[Short],
                                heightInPoints: Option[Short],
                                bold: Option[Boolean],
                                italic: Option[Boolean],
                                charSet: Option[Charset],
                                color: Option[Color],
                                family: Option[FontFamily],
                                scheme: Option[FontScheme],
                                fontName: Option[String],
                                strikeout: Option[Boolean],
                                typeOffset: Option[Short],
                                underline: Option[Underline]) {

  def withHeight(height: Short) =
    copy(height = Option(height))

  def withoutHeight =
    copy(height = None)

  def withHeightInPoints(heightInPoints: Short) =
    copy(heightInPoints = Option(heightInPoints))

  def withoutHeightInPaints =
    copy(heightInPoints = None)

  def withBold =
    copy(bold = Some(true))

  def withoutBold =
    copy(bold = Some(false))

  def withItalic =
    copy(italic = Some(true))

  def withoutItalic =
    copy(italic = Some(false))

  def withCharSet(charSet: Charset) =
    copy(charSet = Option(charSet))

  def withoutCharSet =
    copy(charSet = None)

  def withColor(color: Color) =
    copy(color = Option(color))

  def withoutColor =
    copy(color = None)

  def withFamily(family: FontFamily) =
    copy(family = Option(family))

  def withoutFamily =
    copy(family = None)

  def withScheme(scheme: FontScheme) =
    copy(scheme = Option(scheme))

  def withoutScheme =
    copy(scheme = None)

  def withFontName(fontName: String) =
    copy(fontName = Option(fontName))

  def withoutFontName =
    copy(fontName = None)

  def withStrikeout =
    copy(strikeout = Some(true))

  def withoutStrikeout =
    copy(strikeout = Some(false))

  def withTypeOffset(typeOffset: Short) =
    copy(typeOffset = Option(typeOffset))

  def withoutTypeOffset =
    copy(typeOffset = None)

  def withUnderline(underline: Underline) =
    copy(underline = Option(underline))

  def withoutUnderline =
    copy(underline = None)

  override def toString = "Font[" + List(
    height.map("height=" + _),
    heightInPoints.map("height in points=" + _),
    bold.map("bold=" + _),
    italic.map("italic" + _),
    charSet.map("charset=" + _),
    color.map("color=" + _),
    family.map("family=" + _),
    scheme.map("scheme=" + _),
    fontName.map("font name=" + _),
    strikeout.map("strikeout=" + _),
    typeOffset.map("type offset=" + _),
    underline.map("underline=" + _)
  ).flatten.mkString(", ") + "]"
}

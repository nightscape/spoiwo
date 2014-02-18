package com.norbitltd.spoiwo.model

import org.apache.poi.xssf.usermodel.XSSFCellStyle

object CellBorders extends Factory {

  private lazy val defaultLeftStyle = BorderStyle.None
  private lazy val defaultLeftColor = Color.Undefined
  private lazy val defaultTopStyle = BorderStyle.None
  private lazy val defaultTopColor = Color.Undefined
  private lazy val defaultRightStyle = BorderStyle.None
  private lazy val defaultRightColor = Color.Undefined
  private lazy val defaultBottomStyle = BorderStyle.None
  private lazy val defaultBottomColor = Color.Undefined

  val Default = CellBorders()

  def apply(leftStyle: BorderStyle = defaultLeftStyle, leftColor: Color = defaultLeftColor,
            topStyle: BorderStyle = defaultTopStyle, topColor: Color = defaultTopColor,
            rightStyle: BorderStyle = defaultRightStyle, rightColor: Color = defaultRightColor,
            bottomStyle: BorderStyle = defaultBottomStyle, bottomColor: Color = defaultBottomColor): CellBorders = CellBorders(
    wrap(leftStyle, defaultLeftStyle), wrap(leftColor, defaultLeftColor),
    wrap(topStyle, defaultTopStyle), wrap(topColor, defaultTopColor),
    wrap(rightStyle, defaultRightStyle), wrap(rightColor, defaultRightColor),
    wrap(bottomStyle, defaultBottomStyle), wrap(bottomColor, defaultBottomColor)
  )
}

case class CellBorders(leftStyle: Option[BorderStyle], leftColor: Option[Color],
                      topStyle: Option[BorderStyle], topColor: Option[Color],
                      rightStyle: Option[BorderStyle], rightColor: Option[Color],
                      bottomStyle: Option[BorderStyle], bottomColor: Option[Color]) {

  def withLeftStyle(leftStyle: BorderStyle) =
    copy(leftStyle = Option(leftStyle))

  def withLeftColor(leftColor: Color) =
    copy(leftColor = Option(leftColor))

  def withTopStyle(topStyle: BorderStyle) =
    copy(topStyle = Option(topStyle))

  def withTopColor(topColor: Color) =
    copy(topColor = Option(topColor))

  def withRightStyle(rightStyle: BorderStyle) =
    copy(rightStyle = Option(rightStyle))

  def withRightColor(rightColor: Color) =
    copy(rightColor = Option(rightColor))

  def withBottomStyle(bottomStyle: BorderStyle) =
    copy(bottomStyle = Option(bottomStyle))

  def withBottomColor(bottomColor: Color) =
    copy(bottomColor = Option(bottomColor))

  def withStyle(style: BorderStyle) = {
    val styleOption = Option(style)
    copy(leftStyle = styleOption, topStyle = styleOption, rightStyle = styleOption, bottomStyle = styleOption)
  }

  def withColor(color: Color) = {
    val colorOption = Option(color)
    copy(leftColor = colorOption, topColor = colorOption, rightColor = colorOption, bottomColor = colorOption)
  }

  def applyTo(style: XSSFCellStyle) {
    leftStyle.foreach(s => style.setBorderLeft(s.convert()))
    leftColor.foreach(c => style.setLeftBorderColor(c.convert()))
    bottomStyle.foreach(s => style.setBorderBottom(s.convert()))
    bottomColor.foreach(c => style.setBottomBorderColor(c.convert()))
    rightStyle.foreach(s => style.setBorderRight(s.convert()))
    rightColor.foreach(c => style.setRightBorderColor(c.convert()))
    topStyle.foreach(s => style.setBorderTop(s.convert()))
    topColor.foreach(c => style.setTopBorderColor(c.convert()))
  }
}

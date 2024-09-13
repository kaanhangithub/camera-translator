package com.binarystudios.cameratranslator.presentation.common

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ic_icon_translate: ImageVector
    get() {
        if (_Translate != null) {
            return _Translate!!
        }
        _Translate = ImageVector.Builder(
            name = "Translate",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(4.545f, 6.714f)
                lineTo(4.11f, 8f)
                horizontalLineTo(3f)
                lineToRelative(1.862f, -5f)
                horizontalLineToRelative(1.284f)
                lineTo(8f, 8f)
                horizontalLineTo(6.833f)
                lineToRelative(-0.435f, -1.286f)
                close()
                moveToRelative(1.634f, -0.736f)
                lineTo(5.5f, 3.956f)
                horizontalLineToRelative(-0.049f)
                lineToRelative(-0.679f, 2.022f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 2f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, -2f)
                horizontalLineToRelative(7f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, 2f)
                verticalLineToRelative(3f)
                horizontalLineToRelative(3f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, 2f)
                verticalLineToRelative(7f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2f, 2f)
                horizontalLineTo(7f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2f, -2f)
                verticalLineToRelative(-3f)
                horizontalLineTo(2f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2f, -2f)
                close()
                moveToRelative(2f, -1f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, 1f)
                verticalLineToRelative(7f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                horizontalLineToRelative(7f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                verticalLineTo(2f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                close()
                moveToRelative(7.138f, 9.995f)
                quadToRelative(0.289f, 0.451f, 0.63f, 0.846f)
                curveToRelative(-0.7480f, 0.5750f, -1.6730f, 1.0010f, -2.7680f, 1.2920f)
                curveToRelative(0.1780f, 0.2170f, 0.4510f, 0.6350f, 0.5550f, 0.8670f)
                curveToRelative(1.1250f, -0.3590f, 2.080f, -0.8440f, 2.8860f, -1.4940f)
                curveToRelative(0.7770f, 0.6650f, 1.7390f, 1.1650f, 2.930f, 1.4720f)
                curveToRelative(0.1330f, -0.2540f, 0.4140f, -0.6730f, 0.6290f, -0.890f)
                curveToRelative(-1.1250f, -0.2530f, -2.0570f, -0.6940f, -2.820f, -1.2840f)
                curveToRelative(0.6810f, -0.7470f, 1.2220f, -1.6510f, 1.6210f, -2.7570f)
                horizontalLineTo(14f)
                verticalLineTo(8f)
                horizontalLineToRelative(-3f)
                verticalLineToRelative(1.047f)
                horizontalLineToRelative(0.765f)
                curveToRelative(-0.3180f, 0.8440f, -0.740f, 1.5460f, -1.2720f, 2.130f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.415f, -0.492f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.94f, 0.31f)
            }
        }.build()
        return _Translate!!
    }

private var _Translate: ImageVector? = null

val ic_icon_swap: ImageVector
    get() {
        if (_Swap_horiz != null) {
            return _Swap_horiz!!
        }
        _Swap_horiz = ImageVector.Builder(
            name = "Swap_horiz",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(280f, 800f)
                lineTo(80f, 600f)
                lineToRelative(200f, -200f)
                lineToRelative(56f, 57f)
                lineToRelative(-103f, 103f)
                horizontalLineToRelative(287f)
                verticalLineToRelative(80f)
                horizontalLineTo(233f)
                lineToRelative(103f, 103f)
                close()
                moveToRelative(400f, -240f)
                lineToRelative(-56f, -57f)
                lineToRelative(103f, -103f)
                horizontalLineTo(440f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(287f)
                lineTo(624f, 217f)
                lineToRelative(56f, -57f)
                lineToRelative(200f, 200f)
                close()
            }
        }.build()
        return _Swap_horiz!!
    }

private var _Swap_horiz: ImageVector? = null


val ic_icon_camera: ImageVector
    get() {
        if (_Photo_camera != null) {
            return _Photo_camera!!
        }
        _Photo_camera = ImageVector.Builder(
            name = "Photo_camera",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(480f, 700f)
                quadToRelative(75f, 0f, 127.5f, -52.5f)
                reflectiveQuadTo(660f, 520f)
                reflectiveQuadToRelative(-52.5f, -127.5f)
                reflectiveQuadTo(480f, 340f)
                reflectiveQuadToRelative(-127.5f, 52.5f)
                reflectiveQuadTo(300f, 520f)
                reflectiveQuadToRelative(52.5f, 127.5f)
                reflectiveQuadTo(480f, 700f)
                moveToRelative(0f, -80f)
                quadToRelative(-42f, 0f, -71f, -29f)
                reflectiveQuadToRelative(-29f, -71f)
                reflectiveQuadToRelative(29f, -71f)
                reflectiveQuadToRelative(71f, -29f)
                reflectiveQuadToRelative(71f, 29f)
                reflectiveQuadToRelative(29f, 71f)
                reflectiveQuadToRelative(-29f, 71f)
                reflectiveQuadToRelative(-71f, 29f)
                moveTo(160f, 840f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(80f, 760f)
                verticalLineToRelative(-480f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(160f, 200f)
                horizontalLineToRelative(126f)
                lineToRelative(74f, -80f)
                horizontalLineToRelative(240f)
                lineToRelative(74f, 80f)
                horizontalLineToRelative(126f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(880f, 280f)
                verticalLineToRelative(480f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(800f, 840f)
                close()
                moveToRelative(0f, -80f)
                horizontalLineToRelative(640f)
                verticalLineToRelative(-480f)
                horizontalLineTo(638f)
                lineToRelative(-73f, -80f)
                horizontalLineTo(395f)
                lineToRelative(-73f, 80f)
                horizontalLineTo(160f)
                close()
                moveToRelative(320f, -240f)
            }
        }.build()
        return _Photo_camera!!
    }

private var _Photo_camera: ImageVector? = null

package com.example.speechtotext;

 class CIRCLEVIEW (
     context: Context?,
     attrs: AttributeSet?,
     colour: Int,
     rippleType: Int,
     private val rippleStrokeWidth: Float
) : View(context, attrs) {

         private val paint = Paint()

         init {
             if (context == null) throw IllegalArgumentException("Context is null.")
             if (attrs == null) throw IllegalArgumentException("Attribute set is null.")

             visibility = View.INVISIBLE

             paint.apply {
                 isAntiAlias = true
                 color = colour
                 style = when (rippleType) {
                     FILL.type -> {
                         strokeWidth = 0f
                         Paint.Style.FILL
                     }
                     STROKE.type -> {
                         strokeWidth = rippleStrokeWidth
                         Paint.Style.STROKE
                     }
                     FILL_AND_STROKE.type -> {
                         strokeWidth = rippleStrokeWidth
                         Paint.Style.FILL_AND_STROKE
                     }
                else -> throw IllegalArgumentException("Unknown fill style: $rippleType.")
                 }
             }
         }

         override fun onDraw(canvas: Canvas?) {
             val radius: Float = Math.min(width, height) / 2.toFloat()
             canvas?.drawCircle(radius, radius, radius - rippleStrokeWidth, paint)
         }
     }
}

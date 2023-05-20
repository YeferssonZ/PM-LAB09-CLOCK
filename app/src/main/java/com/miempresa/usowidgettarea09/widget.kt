package com.miempresa.usowidgettarea09

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 */

class widget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            actualizarWidget(context, appWidgetManager, appWidgetId)
        }
    }

    fun actualizarWidget(context: Context, appWidgetManager: AppWidgetManager, widgetId: Int) {
        val controles = RemoteViews(context.packageName, R.layout.widget)

        // Obtener la fecha actual
        val sdfDate = SimpleDateFormat("EEE\nMMM dd", Locale.getDefault())
        val now = Date()
        val fecha = sdfDate.format(now)

        // Actualizar el TextView de la fecha
        controles.setTextViewText(R.id.lblDate, fecha)

        // Obtener la hora actual
        val sdfTime = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val hora = sdfTime.format(now)

        // Actualizar el TextView de la hora
        controles.setTextViewText(R.id.lblTime, hora)

        // Actualizar el widget
        appWidgetManager.updateAppWidget(widgetId, controles)
    }
}

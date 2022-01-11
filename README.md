# Android toggle system ui 

You can show and hide NavigationBar and StatusBar by send broadcast

as follow code :

```kotlin
/**
 * toggle NavigationBar and StatusBar by broadcast
 * @param context context
 * @param show
 *  if true show NavigationBar and StatusBar
 *  if false hide NavigationBar and StatusBar
 * */
private fun toggleSystemUI(context: Context, show: Boolean) {
    val intent = Intent("android.intent.action.action_navigation_bar")
    intent.putExtra("show", show)
    context.sendBroadcast(intent)
}
```
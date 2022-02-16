package pt.zara.android.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import pt.zara.android.data.model.Item
import pt.zara.android.data.model.Item.Companion.toItem

object FirebaseServiceObject {
    private const val TAG = "FirebaseProfileService"

    suspend fun getItem(referenceId: String): Item? {
        val db = FirebaseFirestore.getInstance()
        return try {
            db.collection("Item")
                .document(referenceId).get().await().toItem()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting user details", e)
            null
        }
    }
}
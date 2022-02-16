package pt.zara.android.data.model

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val referenceId: String, //Document ID is actually the user id
                val name: String,
                val description: String,
                val color: String,
                val availableColors: ArrayList<String>,
                val availableColorsInStore: ArrayList<String>,
                val price: String,
                val primaryImageURL: String,
                val otherImagesURL: ArrayList<String>,
                val size: String,
                val availableSizes: ArrayList<String>,
                val availableSizesInStore: ArrayList<String>) : Parcelable {

    companion object {
        fun DocumentSnapshot.toItem(): Item? {
            try {
                val name = getString("name")!!
                val description = getString("description")!!
                val color = getString("color")!!
                val availableColors = get("availableColors")!! as ArrayList<String>
                val availableColorsInStore = get("availableColorsInStore")!!  as ArrayList<String>
                val price = getString("price")!!
                val primaryImageURL = getString("primaryImageURL")!!
                val otherImagesURL = get("otherImagesURL")!! as ArrayList<String>
                val size = getString("size")!!
                val availableSizes = get("availableSizes")!! as ArrayList<String>
                val availableSizesInStore = get("availableSizesInStore")!! as ArrayList<String>
                return Item(id,name,description,color,availableColors,availableColorsInStore,price,
                primaryImageURL,otherImagesURL,size,availableSizes,availableSizesInStore)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }
        private const val TAG = "User"
    }
}
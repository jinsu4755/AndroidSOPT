package sopt.onsopt.semina.domain.user

import android.os.Parcel
import android.os.Parcelable

data class UserDomain(
    val userName:String?,
    val userId:String?,
    val userPassword:String?,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeString(userId)
        parcel.writeString(userPassword)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDomain> {
        override fun createFromParcel(parcel: Parcel): UserDomain {
            return UserDomain(parcel)
        }

        override fun newArray(size: Int): Array<UserDomain?> {
            return arrayOfNulls(size)
        }
    }
}

package sopt.onsopt.semina.domain.user

import android.os.Parcel
import android.os.Parcelable

data class SignUpDomain(
    val email:String?,
    val password:String?,
    val userName:String?,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(userName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SignUpDomain> {
        override fun createFromParcel(parcel: Parcel): SignUpDomain {
            return SignUpDomain(parcel)
        }

        override fun newArray(size: Int): Array<SignUpDomain?> {
            return arrayOfNulls(size)
        }
    }
}

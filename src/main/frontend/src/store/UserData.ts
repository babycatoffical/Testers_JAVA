import {createSlice, type PayloadAction} from "@reduxjs/toolkit";

interface Types {
    id : number,
    donationValue: number,
    name: string,
    email: string,
    displayName: string,
}

const UserData : Types = {
    id: 0,
    donationValue: 0,
    name: "",
    email: "",
    displayName: "",
};

const UserSlice = createSlice({
    name: "Userdata",
    initialState: UserData,
    reducers: {
        setId: (state, action: PayloadAction<number>) => {
          state.id = action.payload;
        },
        increaseDonationValue: (state, action: PayloadAction<number>) => {
            state.donationValue += action.payload;
        },
        decreaseDonationValue: (state, action: PayloadAction<number>) => {
            state.donationValue -= action.payload;
        },
        setName: (state , action: PayloadAction<string>) => {
            state.name = action.payload;
        },
        setEmail: (state, action: PayloadAction<string>) => {
            state.email = action.payload;
        },
        setDisplayName: (state, action: PayloadAction<string>) => {
            state.displayName = action.payload;
        }
    },
});

export default UserSlice.reducer;
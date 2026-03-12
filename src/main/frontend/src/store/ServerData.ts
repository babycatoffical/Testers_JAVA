import {createSlice, type PayloadAction} from "@reduxjs/toolkit";

interface name {
    id: number,
    name: string,
    maxPlayers: number,
    currentPlayers: number,
    status: string,
    isConnected: boolean
}

const ServerData : name = {
    id: 0,
    name: "",
    maxPlayers: 0,
    currentPlayers: 0,
    status: "",
    isConnected: false
}

const ServerSlice = createSlice({
    name: "ServerData",
    initialState: ServerData,
    reducers: {
        setId: (state, action: PayloadAction<number>) => {
            state.id = action.payload
        },
        setName: (state, action: PayloadAction<string>) => {
            state.name = action.payload
        },
        setMaxPlayers: (state, action: PayloadAction<number>) => {
            state.maxPlayers = action.payload
        },
        setCurrentPlayers: (state, action: PayloadAction<number>) => {
            state.currentPlayers = action.payload
        },
        setStatus: (state, action: PayloadAction<string>) => {
            state.status = action.payload
        },
        setConnection: (state, action: PayloadAction<boolean>) => {
          state.isConnected = action.payload
        }
    }
})

export default ServerSlice.reducer;
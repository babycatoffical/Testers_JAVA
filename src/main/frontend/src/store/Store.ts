import {configureStore} from '@reduxjs/toolkit'
import userReducer from './UserData.ts'
import serverReducer from './ServerData.ts'

const store = configureStore({
        reducer: {
            user: userReducer,
            server: serverReducer,
        }
    }
)

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
export type AppStore = typeof store
export default store
import {configureStore} from '@reduxjs/toolkit'
import counterReducer from './UserSlice.ts'

const userStore = configureStore({
        reducer: {
            counter: counterReducer.reducer
        }
    }
)

export type RootState = ReturnType<typeof userStore.getState>
export type AppDispatch = typeof userStore.dispatch
export const AppStore = userStore

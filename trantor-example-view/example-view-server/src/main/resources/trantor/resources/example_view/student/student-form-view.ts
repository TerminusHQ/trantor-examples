import{state, PubSub, action, _, computed, Controller,utils}from 'nusi-sdk'
import { Toast } from '@terminus/nusi'

export default class extends Controller {
// 当字段值发生变化时触发以下方法
  onFieldChange = (filedName: string, value: string) => {
        if (filedName === 'name') {
            const student = this.getContainerByKey('main')
                student.updateData({
                    stuNo: '88888888'
                })
        }
    }
}
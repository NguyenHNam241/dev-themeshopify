import kotlin.collections.ArrayDeque

class EmptyBufferException: Exception()

class BufferFullException: Exception()

class CircularBuffer<T>(val capacity: Int) {

    private val buffer: MutableList<T> = ArrayDeque()

    fun read(): T {
        if (buffer.isEmpty()) {
            throw EmptyBufferException()
        }
        return buffer.removeFirst()
    }

    fun write(value: T) {
        if (isFull()) {
            throw BufferFullException()
        }
        buffer.add(value)
    }

    fun overwrite(value: T) {
        if (isFull()) {
            buffer.removeFirst()
        }
        buffer.add(value)
    }

    fun clear() {
        buffer.clear()
    }

    private fun isFull() = buffer.size == capacity
}
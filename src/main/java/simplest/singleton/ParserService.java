/**
 * MIT License
 * <p>
 * Copyright (c) 2017 James
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package simplest.singleton;

/**
 * 线程安全、双检查锁的单例模式
 * <p>
 * volatile 所修饰的变量可以被看作是一种 “程度较轻的 synchronized ”；
 * 与 synchronized 块相比，volatile 变量所需的编码较少，并且运行时开销也较少，
 * 但是它所能实现的功能也仅是 synchronized 的一部分。
 * <p>
 * 锁提供了两种主要特性：互斥（mutual exclusion） 和可见性（visibility）。
 * 互斥即一次只允许一个线程持有某个特定的锁，因此可使用该特性实现对共享数据的协
 * 调访问协议，这样，一次就只有一个线程能够使用该共享数据。可见性要更加复杂一些，
 * 它必须确保释放锁之前对共享数据做出的更改对于随后获得该锁的另一个线程是可见的
 */
public final class ParserService {

  private static volatile ParserService INSTANCE;

  private ParserService() {
    // 防止通过反射进行实例化
    if (null != INSTANCE) {
      throw new IllegalStateException("该实例已经存在");
    }
  }

  public static ParserService getInstance() {
    // 如果已经被实例化则直接返回该实例
    if (null == INSTANCE) {
      // 无法确定其他的线程是否已经完成初始化
      // 为了确保我们需要锁定一个对象来进行确认
      synchronized (ParserService.class) {
        if (null == INSTANCE) {
          INSTANCE = new ParserService();
        }
      }
    }
    return INSTANCE;
  }

  public String parse(String html){
    return "{'name':'lisa'}";
  }
}

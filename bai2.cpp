#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    long long N, l, u;
    if (cin >> N >> l >> u) {
        long long L = l;
        long long U = min(u, N);
        
        if (L > U) {
            cout << 0 << endl;
        } else {
            long long count = U - L + 1;
            long long sumX0 = (L + U) * count / 2; // Tổng các giá trị của x0
            long long total = count * (N + 1) - sumX0;
            cout << total << endl;
        }
    }
    return 0;
}

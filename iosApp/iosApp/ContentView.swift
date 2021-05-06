import Combine
import SwiftUI
import shared

class ContentViewModel: ObservableObject {
    @Published var products: [Product] = []

    init(
        repository: BuxRepository = BuxRepository()
    ) {
        self.repository = repository
    }

    func onAppear() {
        fetchProducts()
    }

    private func fetchProducts() {
        repository.fetchProducts { [weak self] (product, error) in
            if let error = error {
                print(error.localizedDescription)
                return
            }

            guard let products = product else {
                print("Unexpected error when unwrapping products")
                return
            }

            self?.products = products
        }
    }

    private var repository: BuxRepository
}

struct ContentView: View {
    @ObservedObject var viewModel: ContentViewModel

    var body: some View {
        NavigationView {
            List(viewModel.products, id: \.self) { product in
                HStack {
                    Text(product.displayName)
                    Spacer()
                    Text(product.currentPrice.amount.description)
                }
            }
            .navigationTitle("Products")
        }
        .onAppear(perform: viewModel.onAppear)
    }
}
